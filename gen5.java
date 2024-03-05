import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * @author Jaleah Beason
 * @version 1.0
*/

public class gen5{

	public static void main(String[] args) {
	//Gen5 class creation and main method
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Program5", null, "java/lang/Object", null);
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();

		// printing String 
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitLdcInsn("Hello, world");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		
		// exit main and method visitor
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(0,0);
		mv.visitEnd();
		
byte[] b = cw.toByteArray();

Utilities.writeFile(b, "program5.class");

System.out.println("Done");
	}
}


