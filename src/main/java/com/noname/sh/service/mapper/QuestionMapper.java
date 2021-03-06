package com.noname.sh.service.mapper;

import com.noname.sh.domain.Question;
import com.noname.sh.service.dto.QuestionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Question and its DTO QuestionDTO.
 */
@Mapper(componentModel = "spring", uses = {SectionMapper.class, AnswerMapper.class})
public interface QuestionMapper extends EntityMapper<QuestionDTO, Question> {

    @Mapping(source = "section.id", target = "sectionId")
    @Mapping(source = "section.text", target = "sectionText")
    QuestionDTO toDto(Question question);

    @Mapping(source = "sectionId", target = "section")
    Question toEntity(QuestionDTO questionDTO);

    default Question fromId(Long id) {
        if (id == null) {
            return null;
        }
        Question question = new Question();
        question.setId(id);
        return question;
    }
}
