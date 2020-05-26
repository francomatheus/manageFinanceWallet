package br.com.manageFinanceWallet.Config;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
//@EnableMongoRepositories(basePackageClasses = MessageMongoRepository.class)
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${wallet-mongo.database}")
    private String DATABASE_MONGO_WALLET;
    @Value("${wallet-mongo.uri}")
    private String STRING_CONNECTION_MONGODB;

    @Override
    protected String getDatabaseName() {
        return DATABASE_MONGO_WALLET;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient(new MongoClientURI(STRING_CONNECTION_MONGODB));
    }

}
