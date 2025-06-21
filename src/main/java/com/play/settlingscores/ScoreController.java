package com.play.settlingscores;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class ScoreController {

    static Score score = new Score(30, 10, 20);

    @GetMapping("/health-check")
    public String getHealthCheck(){
        return "Situation Normal all Fired Up";
    }

    @GetMapping("/score")
    public Score getScore(){
        return score;
    }

    @PutMapping("/score")
    public Score replaceScore(@RequestBody Score score){
//        score = new Score();
        return score;
    }

    @DeleteMapping("/score")
    public void deleteScore(){
        score = null;
    }

    @PatchMapping("score/{winsLossesOrTies}")
    public Score updateScore(@PathVariable String winsLossesOrTies, @RequestParam(name = "new-value") int newValue)
    {
        if (winsLossesOrTies.equalsIgnoreCase("wins")){
            score.wins = newValue;
        }
        else if (winsLossesOrTies.equalsIgnoreCase("losses")){
            score.losses = newValue;
        }
        else{
            score.ties = newValue;
        }
        return score;
    }

    @PostMapping("/score/{winsLossesOrTies}")
    public Score increaseWins(@PathVariable String winsLossesOrTies){
        if (winsLossesOrTies.equalsIgnoreCase("wins")){
            score.wins++;
        } else if (winsLossesOrTies.equalsIgnoreCase("losses")) {
            score.losses++;
        }
        else{
            score.ties++;
        }

        return score;
    }

    @GetMapping("/score/{winsLossesOrTies}")
    public int getWinsLossesOrTies(@PathVariable String winsLossesOrTies){
        if(winsLossesOrTies.equalsIgnoreCase("wins")){
            return score.getWins();
        }
        if (winsLossesOrTies.equalsIgnoreCase("losses")) {
            return score.getLosses();
        }
        return score.getTies();
    }
}
