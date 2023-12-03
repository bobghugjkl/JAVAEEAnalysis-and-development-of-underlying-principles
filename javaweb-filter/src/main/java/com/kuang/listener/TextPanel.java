package com.kuang.listener;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class TextPanel {
    public static void main(String[] args) {
        Frame frame = new Frame("中秋节快乐");//窗体
        Panel panel = new Panel(null);//面板
        frame.setLayout(null);//窗体布局

        frame.setBounds(300,300,500,500);
        frame.setBackground(new Color(0,0,255));
        panel.setBounds(50,50,300,300);

        frame.add(panel);
        frame.setVisible(true);
        //监听事件关闭
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("打开");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("关闭ing");
                System.exit(0);//终止,也可以单独只写着一个，适配器模式
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("关闭!");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println();
            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("激活");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("未激活");
            }
        });
    }
}
