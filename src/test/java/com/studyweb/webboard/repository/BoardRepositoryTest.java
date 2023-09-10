package com.studyweb.webboard.repository;

import com.studyweb.webboard.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;


    //수정 필요
    @Test
    void TimeEntity_등록() {
        //given
        LocalDateTime now = LocalDateTime.of(2023, 9, 10, 0, 0, 0);
        System.out.println("now = " + now);
        Board save = boardRepository.save(Board.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        System.out.println("save = " + save);


        //when
        List<Board> boardList = boardRepository.findAll();
        System.out.println("boardList = " + boardList);

        //then
        Board board = boardList.get(0);

        System.out.println(">>>>>>>>>>> createDate= " + board.getCreatedDate()
        +", modeifeidDate="+ board.getModifiedDate());

        assertThat(board.getCreatedDate()).isAfter(now);
        assertThat(board.getModifiedDate()).isAfter(now);
    }

}