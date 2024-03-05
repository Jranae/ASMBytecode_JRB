import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * @author Jaleah Beason
 * @version 1.0
*/

public class gen7{

	public static void main(String[] args) {
	//Gen7 class creation and main method
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Program7", null, "java/lang/Object", null);
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();
		
		//labels creater
		Label whileHeader = new Label();
		Label end = new Label();
		
		//
		mv.visitLdcInsn(1);
		mv.visitVarInsn(Opcodes.ISTORE, 1);
		
		//
		mv.visitLabel(whileHeader);
		mv.visitVarInsn(Opcodes.ILOAD,1);
		mv.visitLdcInsn(5);
		mv.visitJumpInsn(Opcodes.IF_ICMPGE, end);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitVarInsn(Opcodes.ILOAD, 1);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
		
		//
		mv.visitIincInsn(1,1);
		mv.visitJumpInsn(Opcodes.GOTO, whileHeader);
		
		//
		mv.visitLabel(end);
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		
byte[] b = cw.toByteArray();

Utilities.writeFile(b, "program7.class");

System.out.println("Done");
}
}
