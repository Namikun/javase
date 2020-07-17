package cn.tl.io;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.file.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTest {

    public static void main(String[] args) throws Exception {
        //Files.list(Paths.get("E://")).filter(Files::isDirectory).forEach(System.out::println);
        //Files.newDirectoryStream(Paths.get("E://"), name -> name.toString().endsWith(".xlsx")).forEach(System.out::println);
        //Files.newBufferedReader(Paths.get("E://111.txt")).lines().map(String::toUpperCase).forEach(System.out::println);

        Path wPath = Paths.get("F://233.txt");
        if (!Files.exists(wPath)) {
            Files.createFile(wPath);
        }
        BufferedWriter bw = Files.newBufferedWriter(wPath);
        bw.write("what the fuck");
        bw.flush();
        bw.close();

        //flatMap应用
        Arrays.stream(new File("F://intellij//src").listFiles())
                .flatMap(file -> file.isDirectory() ? Stream.of(file.listFiles()) : Stream.of(file))
                .collect(Collectors.toList()).forEach(file -> System.out.println(file));


        //监控文件修改
        Path path = Paths.get("E://");
        WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey watchKey = watchService.poll(3, TimeUnit.SECONDS);
        if (watchKey != null) {
            watchKey.pollEvents()
                    .stream()
                    .forEach(event ->
                            //输出文件名
                            System.out.println(event.context()));
        }
    }
}
