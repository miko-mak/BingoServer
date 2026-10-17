package pl.mikomak.bingoserver.board;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import pl.mikomak.bingoserver.place.PlaceRepository;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final PlaceRepository placeRepository;
    private final Clock clock;

    public BoardService(BoardRepository boardRepository, PlaceRepository placeRepository, Clock clock) {
        this.boardRepository = boardRepository;
        this.placeRepository = placeRepository;
        this.clock = clock;
    }

    public Optional<Board> getBoardByDate(LocalDate date) {
        return this.boardRepository.findById(date.toString());
    }

    public Board getTodayBoard() {
        LocalDate date = LocalDate.now(this.clock);
        Optional<Board> todayBoard = this.getBoardByDate(date);
        return todayBoard.orElseGet(() -> this.generateBoard(date));
    }

    private Board generateBoard(LocalDate date) {
        Board board = BoardGenerator.generateBoard(date, this.placeRepository.findAll());
        try {
            this.boardRepository.insert(board);

        } catch(DuplicateKeyException e) {
            return this.getBoardByDate(date).orElseThrow();
        }

        return board;
    }
}
