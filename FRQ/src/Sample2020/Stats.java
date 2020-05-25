package Sample2020;

import java.util.ArrayList;

public class Stats {

    private ArrayList<ScoreInfo> scoreList;

    /* Part A */
    public boolean record(int score) {
        boolean found = false;

        for (ScoreInfo scoreInfo : scoreList) {
            if (scoreInfo.getScore() == score) {
                scoreInfo.increment();
                found = true;
            }
        }

        if (!found) {
            for (int i = 1; i < scoreList.size() - 1; i++) {
                if (scoreList.get(i).getScore() <= score && scoreList.get(i + 1).getScore() >= score) {
                    scoreList.add(i, new ScoreInfo(score));
                }
            }
        }

        return !found;
    }

    /* Part B */
    public void recordScores(int [] stuScores) {
        for (int score : stuScores) {
            record(score);
        }
    }

    /* Part C */

    /*
        public double getSeniorPercent(int score)
        I need to add a private, integer instance variable to the ScoreInfo class that represents the amount of seniors with the given score.
        I also need to modify the ScoreInfo constructor to include a parameter for the amount of seniors when creating an instance of ScoreInfo,
        and then will initialize the instance variable with the parameter's value. Finally, I need to create a new method in ScoreInfo that eturns the value of the seniors integer instance variable to use in
        getSeniorPercent().
     */
}
