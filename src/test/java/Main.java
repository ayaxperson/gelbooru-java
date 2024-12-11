import me.ajax.boorus.Booru;
import me.ajax.boorus.Boorus;
import me.ajax.boorus.Page;
import me.ajax.boorus.Post;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {

    public static void main(final String[] args) throws IOException, URISyntaxException {
        final Booru safeBooru = new Booru(Boorus.XBOORU);

        final Page noAiPosts = safeBooru.getPage(1, 20, "-ai");

        for (final Post post : noAiPosts.posts()) {
            System.out.println(post.fileURL());
        }
    }

}
