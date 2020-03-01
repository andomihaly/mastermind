package known_object;

import mastermind.CodePegs;
import mastermind.CodePegsColor;

public class KnownMasterMind {
    private CodePegs masterPeg;
    public CodePegs incorrectPegs = new CodePegs(CodePegsColor.Red, CodePegsColor.Red, CodePegsColor.Red, CodePegsColor.Red);
    public CodePegs correctPegs = new CodePegs(CodePegsColor.Red, CodePegsColor.Green, CodePegsColor.Blue, CodePegsColor.Black);


    public CodePegs getMasterPeg() {
        if (masterPeg == null){
            masterPeg = new CodePegs(CodePegsColor.Red, CodePegsColor.Green, CodePegsColor.Blue,CodePegsColor.Black);
        }
        return masterPeg;
    }
}
