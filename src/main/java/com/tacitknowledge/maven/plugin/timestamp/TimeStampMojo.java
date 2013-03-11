package com.tacitknowledge.maven.plugin.timestamp;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.project.MavenProject;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * A simple Mojo that creates a property containing the current timestamp.
 *
 * @author Marek Gilbert &lt;gil@tacitknowledge.com&gt;
 * @phase validate
 * @goal timestamp
 */
public class TimeStampMojo
    extends AbstractMojo
{
    /**
     * Project instance, injected by Maven.
     *  
     * @parameter default-value="${project}"
     * @required
     * @readonly
     */
    @SuppressWarnings ({"UnusedDeclaration"})
    private MavenProject project;

    /**
     * The name of the property the TimeStampMojo is setting in the build.
     *
     * @parameter default-value="build.date"
     */
    @SuppressWarnings ({"UnusedDeclaration"})
    private String property;


    /**
     * Timestamp format for the property the TimeStampMojo is setting
     * in the build.  The default format is ISO-8601.
     *
     * @parameter default-value="yyyy-MM-dd'T'HH:mm:ss.SSSZ"
     */
    @SuppressWarnings ({"UnusedDeclaration"})
    private String format;


    /**
     * Timezone for the timestamp.  Defaults to null which implies the
     * current local timezone.
     *
     * @parameter default-value=null
     */
    @SuppressWarnings ({"UnusedDeclaration"})
    private String timezone;

    /**
     * @see org.apache.maven.plugin.AbstractMojo#execute()
     */
    public void execute()
        throws MojoExecutionException
    {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        if (timezone != null)
        {
            TimeZone zone = TimeZone.getTimeZone(timezone);
            formatter.setTimeZone(zone);
        }
        String value = formatter.format(new Date());

        getLog().info("timestamp " + property + ": " + value);
        project.getProperties().put(property, value);
    }
}
