import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * @author Jaleah Beason
 * @version 1.0
*/

public class gen9{

	public static void main(String[] args) {
	//Gen9 class creation and main method
		ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
		cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "Program9", null, "java/lang/Object", null);
		MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
		mv.visitCode();
		
	//labels for jump instructions
		Label whileHeader = new Label();
		Label end = new Label();
		
	//Initialing/storing Scanner
		mv.visitTypeInsn(Opcodes.NEW, "java/util/Scanner");
		mv.visitInsn(Opcodes.DUP);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/langSystem", "in", "Ljava/io/InputStream;");
		mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V", false);
		mv.visitVarInsn(Opcodes.ASTORE, 0);
		
	//creation of counter variable for while loop and accumulator
		mv.visitLdcInsn(0);
		mv.visitVarInsn(Opcodes.ISTORE, 1);
		mv.visitLdcInsn(0);
		mv.visitVarInsn(Opcodes.ISTORE, 2);
	//while loop
		mv.visitLabel(whileHeader);
		mv.visitVarInsn(Opcodes.ILOAD, 1);
		mv.visitLdcInsn(3);
		mv.visitJumpInsn(Opcodes.IF_ICMPGE, end);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");
		mv.visitLdcInsn("Enter interger to be added to accumulator: ");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintSream", "print", "(Ljava/lang/String;)V", false);
		mv.visitVarInsn(Opcodes.ALOAD, 0);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/util/Scanner", "nextInt", "()I", false);
		mv.visitVarInsn(Opcodes.ILOAD, 2);
		mv.visitInsn(Opcodes.IADD);
		mv.visitVarInsn(Opcodes.ISTORE, 2);
		
	//counter variable and jumping back to top
		mv.visitVarInsn(Opcodes.ILOAD, 1);
		mv.visitLdcInsn(1);
		mv.visitInsn(Opcodes.IADD);
		mv.visitVarInsn(Opcodes.ISTORE, 1);
		mv.visitJumpInsn(Opcodes.GOTO, whileHeader);
		
	// print results for accumulation
		mv.visitLabel(end);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");
		mv.visitLdcInsn("Final result: ");
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintSream", "print", "(Ljava/lang/String;)V", false);
		mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out","Ljava/io/PrintStream;");
		mv.visitVarInsn(Opcodes.ILOAD, 2);
		mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintSream", "println", "(I)V", false);
		
	// exit main and method visitor
		mv.visitInsn(Opcodes.RETURN);
		mv.visitMaxs(0, 0);
		mv.visitEnd();
		
		
byte[] b = cw.toByteArray();

Utilities.writeFile(b, "program9.class");

System.out.println("Done");
	}	
}

