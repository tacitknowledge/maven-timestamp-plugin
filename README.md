The Timestamp plugin creates a property containing a timestamp.  That's it.

------------------------------------------------------------------------------------------------------------------------
Goals
------------------------------------------------------------------------------------------------------------------------

tktimestamp:timestamp creates a property containing a timestamp.  It's not
useful to call this separately, but is useful during a build that does
something else.

------------------------------------------------------------------------------------------------------------------------
POM usage:
------------------------------------------------------------------------------------------------------------------------

To execute the plugin during validate phase of a project you need to specify
plugin usage in the corresponding execution step.  Here are the default plugin
properties explained

<project>
    <build>
        <plugins>
            <plugin>
                <groupId>com.tacitknowledge.maven.plugins</groupId>
                <artifactId>tk-maven-timestamp-plugin</artifactId>

                <executions>
                    <execution>
                        <id>timestamp</id>
                        <phase>validate</phase>
                        <goals>
                            <goal>timestamp</goal>
                        </goals>

                        <configuration>
                            <!--
                            The property to create, defaults to build.date
                            -->
                            <property>build.date</property>

                            <!--
                            The Java SimpleDateFormat to use to use when
                            creating the property value.  Defaults to ISO-8601
                            format.
                            -->
                            <format>yyyy-MM-dd'T'HH:mm:ss.SSSZ</format>

                            <!--
                            The timezone to convert local time to when
                            generating the timestamp.  Defaults to null which
                            means use the local timezone.

                            Any value accepted by TimeZone.getTimeZone() is
                            valid here.
                            -->
                            <timezone>UTC</timezone>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
     </build>
</project>

