FLYWAY_HOME=/Users/$(whoami)/Downloads/flyway-5.2.4
MIGRATION_HOME=/opt/app/spring-demo-dans/rest-web/src/main/resources/flyway #/Users/$(whoami)/spring-demo-dans/rest-web/src/main/resources/flyway

$FLYWAY_HOME/flyway -configFiles=$MIGRATION_HOME/flyway.conf -locations=filesystem:$MIGRATION_HOME/sql migrate

/Users/rizkyperdana/Documents/Demo/spring-demo-dans/rest-web/src/main/resources/flyway