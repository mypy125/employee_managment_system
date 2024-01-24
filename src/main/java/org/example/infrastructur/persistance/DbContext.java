package org.example.infrastructur.persistance;

public abstract class DbContext {
    protected Database database;
    public DbContext(Database database){
        this.database = database;
    }

    protected abstract void onModelBuilder(ModelBuilder builder);
    public boolean saveChanges(){
        return true;
    }
}
class ModelBuilder{
    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        return this;
    }
}
