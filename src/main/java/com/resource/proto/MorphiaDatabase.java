package com.resource.proto;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

public class MorphiaDatabase {
    private static MorphiaDatabase database = new MorphiaDatabase();
    private Datastore datastore;

    private MorphiaDatabase() {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.resource.proto");
        datastore = morphia.createDatastore(new MongoClient(), "proto_morphia");
        datastore.ensureIndexes();
    }

    public static MorphiaDatabase getDatabase() {
        return database;
    }

    public static void setDatabase(MorphiaDatabase database) {
        MorphiaDatabase.database = database;
    }

    public Datastore getDatastore() {
        return datastore;
    }

    public void setDatastore(Datastore datastore) {
        this.datastore = datastore;
    }
}
