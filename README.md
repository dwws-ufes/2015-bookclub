# 2015-bookclub
Assignment for the 2015 edition of the "Web Development and the Semantic Web" course, by Helder Luiz Machado Da Costa and Philipe Grippa B. dos Santos

´BookClub

Para implantar a aplicação seguir os seguintes passos:
	
	1) Baixe o repositorio para sua maquina;
	2) Instale o wildfly 8.2 final
	3) instale o eclipse
	3)Crie um banco de dados no Mysql com nome bookclub usuario: bookclub e senha: bookclub com todos privilegios de acesso.
	4) configure o arquivo standalone.xml que esta presente em wildfly-8.2.0.Final\standalone\configuration inserindo o seguinte codigo em dentro de   <datasources> </datasources> 
	
	<datasource jta="true" jndi-name="java:jboss/datasources/bookclub" pool-name="BookClubPool" enabled="true" use-java-context="true">
                    <connection-url>jdbc:mysql://localhost:3306/bookclub</connection-url>
                    <driver>mysql</driver>
                    <security>
                        <user-name>bookclub</user-name>
                        <password>bookclub</password>
                    </security>
    </datasource>
	
	
	5) No mesmo arquivo standalone.xml adicione a seguinte configuração do drive Mysql em dentro de <drivers>  </drivers>
	
                    <driver name="mysql" module="com.mysql">
                        <driver-class>com.mysql.jdbc.Driver</driver-class>
                    </driver>
					
    6)Em wildfly-8.2.0.Final\modules\com\mysql\main adicione o plungin mysql-connector-java-5.1.34-bin.jar e o arquivo module.xml contendo a seguinte configuração
               
	<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.1" name="com.mysql">
    <resources>
        <resource-root path="mysql-connector-java-5.1.34-bin.jar"/>
    </resources>
    <dependencies>
        <module name="javax.api"/>
    </dependencies>
</module>

7) Abra o eclipse e importe o projeto bookclub(o mavem irá baixar todas as dependencias)
8)Crie um server com o wildfly-8.2.0.Final e adicone o projeto bookclub
9)inicie o server criado
10) acesse o sistema com a url localhost:8080/bookclub/
