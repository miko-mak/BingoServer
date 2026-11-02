package pl.mikomak.bingoserver.time;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BingoTimeController {

    private final BingoTimeService bingoTimeService;

    public BingoTimeController(BingoTimeService bingoTimeService) {
        this.bingoTimeService = bingoTimeService;
    }

    @GetMapping(value = "/api/bingo/expiration")
    public BingoExpiration getExpiration() {
        return bingoTimeService.getBingoExpiration();
    }
}
