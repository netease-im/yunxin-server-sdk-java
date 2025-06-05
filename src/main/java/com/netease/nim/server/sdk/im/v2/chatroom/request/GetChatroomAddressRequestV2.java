package com.netease.nim.server.sdk.im.v2.chatroom.request;

/**
 * Request for getting chatroom address
 * 
 * This class encapsulates the parameters required to get a chatroom address.
 */
public class GetChatroomAddressRequestV2 {

    /**
     * Chatroom ID
     * The ID of the chatroom for which the address is being requested
     */
    private Long roomId;
    
    /**
     * Account ID
     * The ID of the user account entering the chatroom
     */
    private String accountId;
    
    /**
     * Client IP
     * The IP address of the client entering the chatroom
     * The server will return a suitable address based on the client's geographic location
     */
    private String clientIp;
    
    /**
     * Client Type
     * 1 (default): weblink (for Web/HarmonyOS clients)
     * 2: commonlink (for non-Web/HarmonyOS clients)
     * 3: wechatlink (for WeChat mini programs)
     */
    private Integer clientType;
    
    /**
     * IP Protocol Type
     * 0 (default): IPv4
     * 1: IPv6
     * 2: Both
     */
    private Integer ipType;
    
    /**
     * Default constructor
     */
    public GetChatroomAddressRequestV2() {
    }
    
    /**
     * Constructor with required parameters
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID of the user entering the chatroom
     * @param clientIp The IP address of the client
     */
    public GetChatroomAddressRequestV2(Long roomId, String accountId, String clientIp) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.clientIp = clientIp;
    }
    
    /**
     * Constructor with all parameters
     * 
     * @param roomId The ID of the chatroom
     * @param accountId The account ID of the user entering the chatroom
     * @param clientIp The IP address of the client
     * @param clientType The client type (1: weblink, 2: commonlink, 3: wechatlink)
     * @param ipType The IP protocol type (0: IPv4, 1: IPv6, 2: Both)
     */
    public GetChatroomAddressRequestV2(Long roomId, String accountId, String clientIp, Integer clientType, Integer ipType) {
        this.roomId = roomId;
        this.accountId = accountId;
        this.clientIp = clientIp;
        this.clientType = clientType;
        this.ipType = ipType;
    }
    
    /**
     * Get the chatroom ID
     * 
     * @return The chatroom ID
     */
    public Long getRoomId() {
        return roomId;
    }
    
    /**
     * Set the chatroom ID
     * 
     * @param roomId The chatroom ID
     */
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    
    /**
     * Get the account ID
     * 
     * @return The account ID
     */
    public String getAccountId() {
        return accountId;
    }
    
    /**
     * Set the account ID
     * 
     * @param accountId The account ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }
    
    /**
     * Get the client IP address
     * 
     * @return The client IP address
     */
    public String getClientIp() {
        return clientIp;
    }
    
    /**
     * Set the client IP address
     * 
     * @param clientIp The client IP address
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }
    
    /**
     * Get the client type
     * 
     * @return The client type
     */
    public Integer getClientType() {
        return clientType;
    }
    
    /**
     * Set the client type
     * 
     * @param clientType The client type (1: weblink, 2: commonlink, 3: wechatlink)
     */
    public void setClientType(Integer clientType) {
        this.clientType = clientType;
    }
    
    /**
     * Get the IP protocol type
     * 
     * @return The IP protocol type
     */
    public Integer getIpType() {
        return ipType;
    }
    
    /**
     * Set the IP protocol type
     * 
     * @param ipType The IP protocol type (0: IPv4, 1: IPv6, 2: Both)
     */
    public void setIpType(Integer ipType) {
        this.ipType = ipType;
    }
} 