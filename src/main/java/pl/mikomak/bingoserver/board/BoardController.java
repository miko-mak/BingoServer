package pl.mikomak.bingoserver.board;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@RestController
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping(value = "/api/board/today")
    public Board getTodayBoard() {
        return boardService.getTodayBoard();
    }

    @GetMapping(value = "/api/board/{date}")
    public Board getBoardByDate(@PathVariable LocalDate date) {
        Optional<Board> optionalBoard = boardService.getBoardByDate(date);
        if (optionalBoard.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Board not found");
        }

        return optionalBoard.get();
    }

}
