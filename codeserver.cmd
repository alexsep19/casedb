set JAVA_HOME=C:\java\jdk8
set M2_HOME=c:\java\maven3.3.9
set path=%JAVA_HOME%\bin;%M2_HOME%\bin;%PATH%

set classpath=d:/java/gwt-2.8.2/gwt-dev.jar;
set classpath=%classpath%;c:/Users/er22317/.m2/repository/com/google/gwt/inject/gin/2.1.2/gin-2.1.2.jar
set classpath=%classpath%;c:/Users/er22317/.m2/repository/com/google/gwt/inject/gin/2.1.2/gin-2.1.2-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\gwtplatform\gwtp-mvp-client\1.5.3/gwtp-mvp-client-1.5.3.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\gwtplatform\gwtp-mvp-client\1.5.3/gwtp-mvp-client-1.5.3-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\gwtplatform\gwtp-mvp-shared\1.5.3/gwtp-mvp-shared-1.5.3.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\gwtplatform\gwtp-mvp-shared\1.5.3/gwtp-mvp-shared-1.5.3-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\gwtplatform\gwtp-clients-common\1.5.3\gwtp-clients-common-1.5.3.jar

set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material\2.1.1\gwt-material-2.1.1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material\2.1.1\gwt-material-2.1.1-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-jquery\2.1.1\gwt-material-jquery-2.1.1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-jquery\2.1.1\gwt-material-jquery-2.1.1-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-themes\2.1.1\gwt-material-themes-2.1.1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-themes\2.1.1\gwt-material-themes-2.1.1-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-addins\2.1.1\gwt-material-addins-2.1.1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-addins\2.1.1\gwt-material-addins-2.1.1-sources.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-table\2.1.1\gwt-material-table-2.1.1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\gwtmaterialdesign\gwt-material-table\2.1.1\gwt-material-table-2.1.1-sources.jar

set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\github\nmorel\gwtjackson\gwt-jackson\0.15.0\gwt-jackson-0.15.0.jar
set classpath=%classpath%;d:\java\gwt-2.8.2\jackson\jackson-annotations-2.8.0.jar
set classpath=%classpath%;d:\java\gwt-2.8.2\jackson\jackson-annotations-2.8.10-sources.jar
set classpath=%classpath%;d:\java\gwt-2.8.2\jackson\jackson-databind-2.8.4.jar
set classpath=%classpath%;d:\java\gwt-2.8.2\jackson\jackson-databind-2.8.4-sources.jar

set classpath=%classpath%;c:\Users\er22317\.m2\repository\org\fusesource\restygwt\restygwt\2.2.3\restygwt-2.2.3.jar

set classpath=%classpath%;c:\Users\er22317\.m2\repository\javax\inject\javax.inject\1\javax.inject-1.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\javax\inject\javax.inject\1\javax.inject-1-sources.jar

set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\google\inject\guice\3.0\guice-3.0.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\com\google\inject\extensions\guice-assistedinject\3.0\guice-assistedinject-3.0.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\org\apache\velocity\velocity\1.7\velocity-1.7.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\aopalliance\aopalliance\1.0\aopalliance-1.0.jar
set classpath=%classpath%;c:\Users\er22317\.m2\repository\commons-lang\commons-lang\2.4\commons-lang-2.4.jar
set classpath=%classpath%;d:/java/gwt-2.8.2/gwt-user.jar
set classpath=%classpath%;d:/java/gwt-2.8.2/validation-api-1.0.0.GA.jar
set classpath=%classpath%;d:/java/gwt-2.8.2/validation-api-1.0.0.GA-sources.jar
set classpath=%classpath%;d:\iprj\casedb-tb\war-modul\target\classes
set classpath=%classpath%;d:\iprj\casedb-tb\war-modul\src

set classpath=%classpath%;d:/java/gwt-2.8.2/gwt-codeserver.jar

C:\java\jdk8\bin\java -Xmx1024M com.google.gwt.dev.codeserver.CodeServer -allowMissingSrc -port 9877 -logLevel DEBUG -src d:\iprj\casedb-tb\war-modul\src\main\resources\ shu.casedb.GwtMaterialBasic > l