package org.csystem.device;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(prefix = "m_")
@ToString
@Builder
public class DeviceData {
    private String m_name;
    private String m_host;
    private int m_port;
    private Object m_data;
}
