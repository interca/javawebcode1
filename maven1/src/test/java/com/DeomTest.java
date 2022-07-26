package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class DeomTest {
    @Test
    public  void test(){
        Demo p=new Demo();
       String str= p.say("eeee");
        Assert.assertEquals("hello eeee",str);
    }
}
