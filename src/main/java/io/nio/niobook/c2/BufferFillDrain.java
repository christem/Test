package io.nio.niobook.c2;

import java.nio.CharBuffer;

/**
 * 例2.1 填充和释放缓冲区
 * 
 * 如果您对缓冲区有专门的控制，这种方法会更高效，因为上界不会在每次循环重复时都被 检查（这要求调用一个 buffer 样例程序） 。
 * 上文中的第一个例子允许多线程同时从缓冲区释 放元素
 * 
 * 
 * 一旦缓冲区对象完成填充并释放，它就可以被重新使用了。 Clear()函数将缓冲区重置 为空状态。
 * 它并不改变缓冲区中的任何数据元素，而是仅仅将上界设为容量的值，并把位置设 回 0， 如图 2.2 所示。这使得缓冲区可以被重新填入
 * 
 * @author yis
 *
 */
public class BufferFillDrain {
    public static void main(String[] argv) throws Exception {
	CharBuffer buffer = CharBuffer.allocate(100);
	while (fillBuffer(buffer)) {
	    buffer.flip();
	    drainBuffer(buffer);
	    buffer.clear();
	}
    }

    private static void drainBuffer(CharBuffer buffer) {
	while (buffer.hasRemaining()) {
	    System.out.print(buffer.get());
	}
	System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
	if (index >= strings.length) {
	    return (false);
	}
	String string = strings[index++];
	for (int i = 0; i < string.length(); i++) {
	    buffer.put(string.charAt(i));
	}

	return (true);
    }

    private static int index = 0;
    private static String[] strings = { "A random string value", "The product of an infinite number of monkeys",
	    "Hey hey we're the Monkees", "Opening act for the Monkees: Jimi Hendrix", "'Scuse me while I kiss this fly",
	    "Help Me! Help Me!", };
}
