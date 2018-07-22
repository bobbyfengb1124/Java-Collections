package nio.path;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

	public static void main(String[] args) {
        try {
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
//            Files.deleteIfExists(fileToDelete);
//
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.move(fileToMove, destination);

//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1copy.txt");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
////
//            sourceFile = FileSystems.getDefault().getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
            
//          Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//          Files.createFile(fileToCreate);
//          Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//          Files.createDirectory(dirToCreate);
//          Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2/Dir3/Dir4/Dir5/Dir6");
//          Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");

//          Path dirToCreate = FileSystems.getDefault().getPath("Examples/Dir2/Dir3/Dir4/Dir5/Dir6/Dir7");
////          Path dirToCreate = FileSystems.getDefault().getPath("Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
//          Files.createDirectories(dirToCreate);

          Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
//          Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1\\file1.txt");
          long size = Files.size(filePath);
          System.out.println("Size = " + size);
          System.out.println("Last modified =  " + Files.getLastModifiedTime(filePath));


          BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
          System.out.println("Size =  " + attrs.size());
          System.out.println("Last modified =  " + attrs.lastModifiedTime());
          System.out.println("Created = " + attrs.creationTime());
          System.out.println("Is directory = " + attrs.isDirectory());
          System.out.println("Is regular file = " + attrs.isRegularFile());

          //            Path fileToDelete = FileSystems.getDefault().getPath("Examples", "Dir1", "file1copy.txt");
          //            Files.deleteIfExists(fileToDelete);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
