import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * @author Jaleah Beason
 * @version 1.0
*/

public class gen3{

	public static void main(String[] args) {
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Program3", null, "java/lang/Object", null);
	// gen3 constructor
	{
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC, "<init>", "()V", null, null);
		mv.visitCode();
		mv.visitVarInsn(Opcodes.ALOAD,0);
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(1,1);
		mv.visitEnd();
	}
	// gen3 main method
	{
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();
		
	// Divide two integers
		mv.visitLdcInsn(20);	
		mv.visitVarInsn(Opcodes.ISTORE, 12);
		mv.visitLdcInsn(2);
		mv.visitVarInsn(Opcodes.ISTORE, 13);
		mv.visitVarInsn(Opcodes.ILOAD, 12);
		mv.visitVarInsn(Opcodes.ILOAD, 13);
		mv.visitInsn(Opcodes.IDIV);
		mv.visitVarInsn(Opcodes.ISTORE, 5);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitVarInsn(Opcodes.ILOAD, 5);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

	// Divide two floats
		mv.visitLdcInsn(25.5f);	
		mv.visitVarInsn(Opcodes.FSTORE, 1);
		mv.visitLdcInsn(5.5f);
		mv.visitVarInsn(Opcodes.FSTORE, 3);
		mv.visitVarInsn(Opcodes.FLOAD, 1);
		mv.visitVarInsn(Opcodes.FLOAD, 3);
		mv.visitInsn(Opcodes.FDIV);
		mv.visitVarInsn(Opcodes.FSTORE, 5);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitVarInsn(Opcodes.FLOAD, 5);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

	// Divide two doubles
		mv.visitLdcInsn(200.0);
		mv.visitVarInsn(Opcodes.DSTORE, 6);
		mv.visitLdcInsn(4.0);
		mv.visitVarInsn(Opcodes.DSTORE, 8);
		mv.visitVarInsn(Opcodes.DLOAD, 6);
		mv.visitVarInsn(Opcodes.DLOAD, 8);
		mv.visitInsn(Opcodes.DDIV);
		mv.visitVarInsn(Opcodes.DSTORE, 10);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		mv.visitVarInsn(Opcodes.DLOAD, 10);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
	}
	
cw.visitEnd();

byte[] b = cw.toByteArray();

Utilities.writeFile(b, "program3.class");

System.out.println("Done");

}

}
