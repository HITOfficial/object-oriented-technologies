package pl.edu.agh.school.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import pl.edu.agh.school.persistence.ISerializablePersistenceManager;
import pl.edu.agh.school.persistence.SerializablePersistenceManager;

public class SchoolModule extends AbstractModule {
    @Provides
    public ISerializablePersistenceManager providePersistenceManager(ISerializablePersistenceManager manager) {
        return new SerializablePersistenceManager();
    }
}
