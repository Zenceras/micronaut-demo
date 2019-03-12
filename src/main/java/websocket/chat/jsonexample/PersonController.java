package websocket.chat.jsonexample;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Single;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


@Controller("/people")
public class PersonController {

    Map<String, Person> inMemoryDatastore = new LinkedHashMap<>();


    // simple variant
    @Post("/simple")
    public HttpResponse<Person> save(@Body Person person) {
        inMemoryDatastore.put(person.getFirstName(), person);
        return HttpResponse.created(person);
//        return HttpResponse.created(new Person("Ivan", "Ivanov", 45)); //or serialize new Person if you want
    }

    // 2 Async variants
    @Post("/future")
    public CompletableFuture<HttpResponse<Person>> save(@Body CompletableFuture<Person> person) {
        return person.thenApply(p -> {
                    inMemoryDatastore.put(p.getFirstName(), p);
                    return HttpResponse.created(p);
                }
        );
    }

    @Post("/single")
    public Single<HttpResponse<Person>> save(@Body Single<Person> person) {
        return person.map(p -> {
                    inMemoryDatastore.put(p.getFirstName(), p);
                    return HttpResponse.created(p);
                }
        );
    }
}
