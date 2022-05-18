import Entities.House;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

import java.io.*;

public class IOTest {
    @Test
    public void testWriteWithDataOutputStream() throws IOException {
        int[] numbers = {512, 300, 130};
        byte[] expectations = {0,0,2,0,0,0,1,44,0,0,0,-126};
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        IO.writeIntWithDataOutputStream(os, numbers);
        Assertions.assertArrayEquals(expectations, os.toByteArray());
    }
    @Test
    public void testReadWithDataInputStream() throws IOException {
        int[] expectations = {100, 2, 3};
        byte[] expectationsBytes = {0,0,0,100,0,0,0,2,0,0,0,3};
        ByteArrayInputStream is = new ByteArrayInputStream(expectationsBytes);
        Assertions.assertArrayEquals(IO.readIntWithDataInputStream(is, expectations.length), expectations);
    }
    @Test
    public void testWriteCharStream() throws IOException {
        int[] numbers = {-2, 0, 2};
        StringWriter sw = new StringWriter();
        IO.writeCharStream(sw, numbers);
        String expectations = "-2 0 2 ";
        Assertions.assertEquals(sw.toString(), expectations);
    }
    @Test
    public void testReadCharStream() throws IOException {
        int[] expectations = {-2, 0, 2};
        String numbers = "-2 0 2 ";
        StringReader sr = new StringReader(numbers);
        Assertions.assertArrayEquals(expectations, IO.readCharStream(sr, expectations.length));
    }
    @Test
    public void testReadIntegersBeginWithPosition() throws IOException {
        long pos = 2 * Integer.BYTES;
        RandomAccessFile raf = new RandomAccessFile("src\\main\\resources\\testfile", "rw");

        try (raf) {
            raf.writeInt(3);
            raf.writeInt(-233);
            raf.writeInt(777);
            raf.writeInt(-1024);
            int[] exp = {777, -1024};
            Assertions.assertArrayEquals(IO.readIntegersBeginWithPosition(raf, pos), exp);
        }
    }
    @Test
    public void testGetFilesListWithExtension(){
        File dir = new File("src\\main\\resources");
        String[] expectations = new String[] {"1file.txt", "2file.txt"};
        try {
            File file1 = new File("src\\main\\resources", "1file.txt");
            file1.createNewFile();
            File file2 = new File("src\\main\\resources","2file.txt");
            file2.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();

        }

        Assertions.assertArrayEquals(expectations, IO.getFilesListWithExtension(dir, "txt"));
    }
    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        PodamFactory factory = new PodamFactoryImpl();
        House house = new House(factory.manufacturePojo(String.class), factory.manufacturePojo(String.class));

        String filename = "src\\main\\resources\\test_file.txt";
        ObjectOutput out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
        Service.serialization(house, out);
        out.close();

        ObjectInput in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));
        House houseReaded = Service.deserialization(in);
        Assertions.assertEquals(houseReaded, house);
        in.close();
    }
    @Test
    public void testJackson() throws JsonProcessingException {
        PodamFactory factory = new PodamFactoryImpl();
        House house = new House(factory.manufacturePojo(String.class), factory.manufacturePojo(String.class));

        House houseReaded = Service.jacksonDeserialization(Service.jacksonSerialization(house));
        Assertions.assertEquals(houseReaded, house);
    }
}
