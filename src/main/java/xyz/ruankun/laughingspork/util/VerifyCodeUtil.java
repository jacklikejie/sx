package xyz.ruankun.laughingspork.util;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      Buddha Bless, No Bug !

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author zct
 * @date 2018��2��6��
 * @param
 * @desc ͼ����֤������
 *
 */
public class VerifyCodeUtil {
    // ��֤���ַ���
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    // �ַ�����
    private static final int SIZE = 7;
    // ����������
    private static final int LINES = 5;
    // ����
    private static final int WIDTH = 140;
    // �߶�
    private static final int HEIGHT = 40;
    // �����С
    private static final int FONT_SIZE = 30;

    /**
     * ���������֤�뼰ͼƬ
     * Object[0]����֤���ַ�����
     * Object[1]����֤��ͼƬ��
     */
    public static Object[] createImage() {
        StringBuffer sb = new StringBuffer();
        // 1.�����հ�ͼƬ
        BufferedImage image = new BufferedImage(
                WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        // 2.��ȡͼƬ����
        Graphics graphic = image.getGraphics();
        // 3.���û�����ɫ
        graphic.setColor(Color.LIGHT_GRAY);
        // 4.���ƾ��α���
        graphic.fillRect(0, 0, WIDTH, HEIGHT);
        // 5.������ַ�
        Random ran = new Random();
        for (int i = 0; i <SIZE; i++) {
            // ȡ����ַ�����
            int n = ran.nextInt(chars.length);
            // ���������ɫ
            graphic.setColor(getRandomColor());
            // ���������С
            graphic.setFont(new Font(
                    null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            // ���ַ�
            graphic.drawString(
                    chars[n] + "", i * WIDTH / SIZE, HEIGHT*2/3);
            // ��¼�ַ�
            sb.append(chars[n]);
        }
        // 6.��������
        for (int i = 0; i < LINES; i++) {
            // ���������ɫ
            graphic.setColor(getRandomColor());
            // �������
            graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT),
                    ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
        }
        // 7.������֤���ͼƬ
        return new Object[]{sb.toString(), image};
    }

    /**
     * ���ȡɫ
     */
    public static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }

    public static void setVerifyCode(String code){
        VerifyCodePool.setVerifyCode(code);
    }

    public static boolean verify(String code){
        return VerifyCodePool.verify(code);
    }
}