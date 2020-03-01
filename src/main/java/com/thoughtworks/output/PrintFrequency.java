package com.thoughtworks.output;

public class PrintFrequency implements IOutputInstruction {

    private final String[] frequency = {"一", "二", "三", "四", "五", "六"};
    private final int curFrequency;

    public PrintFrequency(int curFrequency) {
        this.curFrequency = curFrequency;
    }

    @Override
    public String printInstruction() {
        return "// 第" + frequency[curFrequency] + "次";
    }
}
