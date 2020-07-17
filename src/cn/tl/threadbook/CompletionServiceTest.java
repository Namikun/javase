package cn.tl.threadbook;

import cn.tl.domain.ImageInfo;
import com.sun.scenario.effect.ImageData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 模拟两个任务
 * 1. 渲染所有文本
 * 2.下载所有图片
 * completionService.submit方法把任务交给线程执行，同时把任务放入队列里
 */
public class CompletionServiceTest {

    private final ExecutorService executorService;

    public CompletionServiceTest(ExecutorService executorService) {
        this.executorService = executorService;
    }

    public void renderPage(CharSequence source) {
        List<ImageInfo> info = scanForImageInfo(source);
        CompletionService<ImageData> completionService = new ExecutorCompletionService<>(executorService);
        for (ImageInfo imageInfo : info) {
            completionService.submit(() -> imageInfo.downloadImage());
        }

        // 渲染所有文本
        // renderText(source)
        try {
            for (int i = 0, n = info.size(); i < n; i++) {
                Future<ImageData> f = completionService.take();
                ImageData imageData = f.get();
                // 显示图片
                // renderImage(imageData)
            }
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }

    }

    public List<ImageInfo> scanForImageInfo(CharSequence source) {

        return new ArrayList<>();
    }
}
