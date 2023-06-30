package uz.gpt.gpt.service;

import uz.gpt.gpt.dto.GeneralResponse;
import uz.gpt.gpt.dto.request.ChatRequestDto;
import uz.gpt.gpt.dto.response.ChatResponseDto;
import uz.gpt.gpt.dto.response.ProfessionListDto;

import java.io.IOException;
import java.util.List;

public interface GtpService {

    GeneralResponse<List<ProfessionListDto>> getProfessions();

    GeneralResponse<ChatResponseDto> chatWithGPT(ChatRequestDto dto) throws IOException;
}
