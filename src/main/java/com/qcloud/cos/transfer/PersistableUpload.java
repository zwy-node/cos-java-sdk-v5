package com.qcloud.cos.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;

public final class PersistableUpload extends PersistableTransfer {
    static final String TYPE = "upload";

    @JsonProperty
    private final String pauseType = TYPE;

    /** The bucket name in Qcloud COS from where the object has to be uploaded. */
    @JsonProperty
    private final String bucketName;

    /** The name of the object in Qcloud COS. */
    @JsonProperty
    private final String key;

    /** The file to upload. */
    @JsonProperty
    private final String file;

    /** The multi-part upload id associated with this upload. */
    @JsonProperty
    private final String multipartUploadId;

    /** The part size to be used for the multi-part upload. */
    @JsonProperty
    private final long partSize;

    /** The upper threshold of the file to use multi part upload. */
    @JsonProperty
    private final long mutlipartUploadThreshold;

    public PersistableUpload() {
        this(null, null, null, null, -1, -1);
    }

    public PersistableUpload(@JsonProperty(value = "bucketName") String bucketName,
            @JsonProperty(value = "key") String key, @JsonProperty(value = "file") String file,
            @JsonProperty(value = "multipartUploadId") String multipartUploadId,
            @JsonProperty(value = "partSize") long partSize,
            @JsonProperty(value = "mutlipartUploadThreshold") long mutlipartUploadThreshold) {
        this.bucketName = bucketName;
        this.key = key;
        this.file = file;
        this.multipartUploadId = multipartUploadId;
        this.partSize = partSize;
        this.mutlipartUploadThreshold = mutlipartUploadThreshold;
    }

    /**
     * Returns the name of the bucket.
     */
    public String getBucketName() {
        return bucketName;
    }

    /**
     * Returns the name of the object.
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the multi part upload id.
     */
    public String getMultipartUploadId() {
        return multipartUploadId;
    }

    /**
     * Returns the part size to be used in multi part upload.
     */
    public long getPartSize() {
        return partSize;
    }

    /**
     * Returns the upper threshold for file size after which multipart upload is used..
     */
    public long getMutlipartUploadThreshold() {
        return mutlipartUploadThreshold;
    }

    /**
     * Returns the file name along with path which needs to be uploaded to Qcloud COS.
     */
    public String getFile() {
        return file;
    }

    public String getPauseType() {
        return pauseType;
    }
}
