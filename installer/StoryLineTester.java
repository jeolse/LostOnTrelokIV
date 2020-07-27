package lostontrelokiv.installer;


/**
 *
 * @author jedi
 */
public class StoryLineTester {

    public static final int MAX_NODES = 11; //10,  [0] == empty
    public static final int MAX_QUESTIONS = 4; //3, [0] == empty
    
    private final String[] STORY_FIN = new String[MAX_NODES];
    private final String[] QUESTIONS_FIN = new String[MAX_NODES];
    private final String[][] QUESTION_FIN = new String[MAX_NODES][MAX_QUESTIONS];

    public StoryLineTester() {

        STORY_FIN[1] = "Story 1";
        QUESTIONS_FIN[1] = "Question a\nQuestion b\nQuestion c";
        QUESTION_FIN[1][1] = "Story 1: Question a";
        QUESTION_FIN[1][2] = "Story 1: Question b";
        QUESTION_FIN[1][3] = "Story 1: Question c";

        STORY_FIN[2] = "Story 2";
        QUESTIONS_FIN[2] = "Question a\nQuestion b\nQuestion c";
        QUESTION_FIN[2][1] = "Story 2: Question a";
        QUESTION_FIN[2][2] = "Story 2: Question b";
        QUESTION_FIN[2][3] = "Story 2: Question c";

        STORY_FIN[3] = "Story 3";
        QUESTIONS_FIN[3] = "Question a\nQuestion b\nQuestion c";
        QUESTION_FIN[3][1] = "Story 3: Question a";
        QUESTION_FIN[3][2] = "Story 3: Question b";
        QUESTION_FIN[3][3] = "Story 3: Question c";

        STORY_FIN[4] = "Story 4";
        QUESTIONS_FIN[4] = "Question a\nQuestion b\nQuestion c";
        QUESTION_FIN[4][1] = "Story 4: Question a";
        QUESTION_FIN[4][2] = "Story 4: Question b";
        QUESTION_FIN[4][3] = "Story 4: Question c";

    }


    public String getStoryForNode(int nodeId) {
        return STORY_FIN[nodeId];
    }


    public String getQuestionForNode(int nodeId) {
        return QUESTIONS_FIN[nodeId];
    }


    public String getQuestionForNode(int nodeId, int question) {
        return QUESTION_FIN[nodeId][question];
    }


}
