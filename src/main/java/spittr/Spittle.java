package spittr;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Date;

/**
 * 用户推送的消息
 */
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;//纬度
    private Double longitude;//经度

    //spring3.0之后，springmvc提供了参数校验API
//    @NotNull
//    @Size(min=5,max=16)
//    private String username;
//    @NotNull
//    @Size(min=5,max=25)
//    private String password;
//    @NotNull
//    @Size(min=2,max=30)
//    private String firstName;
//    @NotNull
//    @Size(min=2,max=30)
//    private String lastName;


    public Spittle(String message, Date time) {
        this(message,time,null,null);
    }

    public Spittle(String message, Date time, Double longitude, Double latitude) {
        this.id = 123L;
        this.message = message;
        this.time = time;
        this.longitude=longitude;
        this.latitude=latitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    /**
     *  ??这么写原因待查
     * @param that
     * @return
     */
    @Override
    public boolean equals(Object that) {

        return EqualsBuilder.reflectionEquals(this,that,"id","time");
    }

    /**
     * ??这么写原因待查
     * @return
     */
    @Override
    public int hashCode() {

        return HashCodeBuilder.reflectionHashCode(this,"id","time");
    }

//    public String getUsername() {
//        return username;
//    }
}
