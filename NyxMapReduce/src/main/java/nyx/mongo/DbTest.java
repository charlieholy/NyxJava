package nyx.mongo;

import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoClientURI;
import org.mortbay.util.ajax.JSON;

public class DbTest {
    public static void main(String[] args) {
        MongoClientURI uri = new MongoClientURI("mongodb://127.0.0.1");
        Mongo mongo = Mongo.Holder.singleton().connect(uri);
        System.out.println(JSON.toString(mongo.getUsedDatabases()));
    }
}
