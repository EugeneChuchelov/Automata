package entity;

import java.util.List;

public class Function {
    private List<Character> fromSymbols;
    private Character fromState;

    private Character inputSymbol;

    private List<Character> toSymbols;
    private Character toState;

    public Character getFromState() {
        return fromState;
    }

    public void setFromState(Character fromState) {
        this.fromState = fromState;
    }

    public List<Character> getFromSymbols() {
        return fromSymbols;
    }

    public void setFromSymbols(List<Character> fromSymbols) {
        this.fromSymbols = fromSymbols;
    }

    public Character getInputSymbol() {
        return inputSymbol;
    }

    public void setInputSymbol(Character inputSymbol) {
        this.inputSymbol = inputSymbol;
    }

    public List<Character> getToSymbols() {
        return toSymbols;
    }

    public void setToSymbols(List<Character> toSymbols) {
        this.toSymbols = toSymbols;
    }

    public Character getToState() {
        return toState;
    }

    public void setToState(Character toState) {
        this.toState = toState;
    }
}
