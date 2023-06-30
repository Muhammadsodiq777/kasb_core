package uz.gpt.gpt.service.impl;

import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import uz.gpt.gpt.dto.GeneralResponse;
import uz.gpt.gpt.dto.gpt_request_dto.GPTMainModel;
import uz.gpt.gpt.dto.gpt_request_dto.GptMessages;
import uz.gpt.gpt.dto.gpt_response_dto.ChatCompletionResponse;
import uz.gpt.gpt.dto.gpt_response_dto.Choice;
import uz.gpt.gpt.dto.request.ChatRequestDto;
import uz.gpt.gpt.dto.response.ChatResponseDto;
import uz.gpt.gpt.dto.response.ProfessionListDto;
import uz.gpt.gpt.service.GtpService;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@Service
public class GtpServiceImpl implements GtpService {

    @Override
    public GeneralResponse<List<ProfessionListDto>> getProfessions() {

        List<ProfessionListDto> profList = Arrays.asList(
                new ProfessionListDto(1, "Qonun"),
                new ProfessionListDto(2, "Doktor"),
                new ProfessionListDto(3, "Quruvchi"),
                new ProfessionListDto(4, "Dasturchi")
        );

        return new GeneralResponse<>(true, 1, "success", profList);
    }

    @Override
    public GeneralResponse<ChatResponseDto> chatWithGPT(ChatRequestDto dto) throws IOException {
        String apiKey = "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";

        // Set the API endpoint URL
        String apiUrl = "https://api.openai.com/v1/chat/completions";

        // Create the payload object
        GPTMainModel mainModel = new GPTMainModel();
        mainModel.setModel("gpt-3.5-turbo");

        List<GptMessages> messagesList = Arrays.asList(
                new GptMessages("user", dto.getRequest())
        );
         mainModel.setMessages(messagesList);
        // Convert the payload to JSON string
        String payloadJson = new Gson().toJson(mainModel) ;

        // Create the URL object and open the connection
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the HTTP request method and headers
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);

        // Enable output and input streams for the connection
        connection.setDoOutput(true);
        connection.setDoInput(true);

        // Write the request payload to the connection
        try (DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream())) {
            outputStream.write(payloadJson.getBytes("UTF-8"));
            outputStream.flush();
        }

        // Get the response code
        int responseCode = connection.getResponseCode();

        // Read the response from the connection
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            // Cast the response
            Gson gson = new Gson();
            ChatCompletionResponse completionResponse = gson.fromJson(String.valueOf(response), ChatCompletionResponse.class);
            Choice[] choices = completionResponse.getChoices();
            String content = choices[0].getMessage().getContent();

            if(responseCode == 200) {
                return new GeneralResponse<>(true, responseCode, "success", new ChatResponseDto(dto.getCode(), content));
            }

        }

        // Close the connection
        connection.disconnect();

        return new GeneralResponse<>(false, responseCode, "fail", new ChatResponseDto(-1, "Qaytadan urinib ko'ring"));
    }
}
