package file_handles;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil<T> {
    private final String filePath;

    public FileUtil(String filePath) {
        this.filePath = filePath;
    }

    // Ghi một đối tượng vào danh sách trong file - create object to file
    public void writeObjectToFile(T obj) { // T is generics
        List<T> objectList = readObjectsFromFile();
        if (!objectList.contains(obj)) {
            objectList.add(obj);
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                oos.writeObject(objectList);
                System.out.println("Đối tượng đã được thêm vào file.");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Đối tượng đã tồn tại trong file.");
        }
    }

    // Đọc danh sách các đối tượng từ file - read from file
    @SuppressWarnings("unchecked")
    public List<T> readObjectsFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }



    // Sửa danh sách các đối tượng từ file - update in file
    public void updateObjectInFile(T object) {
        // xu li sua doi thong tin tu file

    }


    // Xóa danh sách các đối tượng từ file - delete in file
    public void deleteObjectInFile(T object) {
        // tim object co ton tai trong file khong thi xoa no.



    }

}
