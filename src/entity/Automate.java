package entity;

import java.util.List;

public class Automate {
    private List<Character> states;
    private Character startState;
    private List<Character> alphabet;
    private List<Character> terminalAlphabet;
    private Character startSymbol;
    private List<Character> finalStates;
    private List<Function> functions;

    public List<Character> getStates() {
        return states;
    }

    public void setStates(List<Character> states) {
        this.states = states;
    }

    public Character getStartState() {
        return startState;
    }

    public void setStartState(Character startState) {
        this.startState = startState;
    }

    public List<Character> getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(List<Character> alphabet) {
        this.alphabet = alphabet;
    }

    public List<Character> getTerminalAlphabet() {
        return terminalAlphabet;
    }

    public void setTerminalAlphabet(List<Character> terminalAlphabet) {
        this.terminalAlphabet = terminalAlphabet;
    }

    public Character getStartSymbol() {
        return startSymbol;
    }

    public void setStartSymbol(Character startSymbol) {
        this.startSymbol = startSymbol;
    }

    public List<Character> getFinalStates() {
        return finalStates;
    }

    public void setFinalStates(List<Character> finalStates) {
        this.finalStates = finalStates;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }
}
