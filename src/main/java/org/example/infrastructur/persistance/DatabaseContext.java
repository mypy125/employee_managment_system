package org.example.infrastructur.persistance;

import org.example.infrastructur.persistance.configurations.EmployeeConfiguration;

public class DatabaseContext extends DbContext{
    public DatabaseContext(Database database) {
        super(database);
    }

    @Override
    protected void onModelBuilder(ModelBuilder builder) {
        builder.applyConfiguration(new EmployeeConfiguration());
    }
}
