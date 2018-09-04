package cn.ezandroid.ezdownload;

import java.io.Serializable;

/**
 * 文件下载请求
 *
 * @author like
 * @date 2018-09-03
 */
public class DownloadFileRequest implements Serializable, Cloneable {

    private static final long serialVersionUID = 42L;

    private static final int MAX_RETRY_COUNT = 3;

    private long mTotalContentLength;
    private long mBlockSize;
    private int mBlockPosition;

    private long mStartPosition;
    private long mEndPosition;

    private long mCurrentLength;

    private float mProgress;
    private int mRetryCount;
    private DownloadStatus mStatus = DownloadStatus.IDLE;
    private boolean mSupportRange;

    private String mUrl;
    private String mPath;

    public DownloadFileRequest(String url, String path,
                               long totalContentLength, long blockSize, int blockPosition,
                               boolean supportRange) {
        this.mUrl = url;
        this.mPath = path;

        this.mTotalContentLength = totalContentLength;
        this.mBlockSize = blockSize;
        this.mBlockPosition = blockPosition;

        this.mStartPosition = blockSize * blockPosition;
        this.mEndPosition = blockSize * blockPosition + blockSize;

        mSupportRange = supportRange;
    }

    @Override
    protected DownloadFileRequest clone() throws CloneNotSupportedException {
        return (DownloadFileRequest) super.clone();
    }

    @Override
    public String toString() {
        return "from " + mStartPosition +
                " to " + mEndPosition +
                " > " + mCurrentLength +
                " " + mStatus;
    }

    public boolean isSupportRange() {
        return mSupportRange;
    }

    public void setSupportRange(boolean supportRange) {
        mSupportRange = supportRange;
    }

    public void addRetryCount() {
        mRetryCount++;
    }

    public boolean shouldRetry() {
        return mRetryCount < MAX_RETRY_COUNT;
    }

    public void setCurrentLength(long currentLength) {
        mCurrentLength = currentLength;
    }

    public long getCurrentLength() {
        return mCurrentLength;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String path) {
        this.mPath = path;
    }

    public long getTotalContentLength() {
        return mTotalContentLength;
    }

    public void setTotalContentLength(long totalContentLength) {
        this.mTotalContentLength = totalContentLength;
    }

    public long getBlockSize() {
        return mBlockSize;
    }

    public void setBlockSize(long blockSize) {
        this.mBlockSize = blockSize;
    }

    public int getBlockPosition() {
        return mBlockPosition;
    }

    public void setBlockPosition(int blockPosition) {
        this.mBlockPosition = blockPosition;
    }

    public long getStartPosition() {
        return mStartPosition;
    }

    public void setStartPosition(long startPosition) {
        this.mStartPosition = startPosition;
    }

    public long getEndPosition() {
        return mEndPosition;
    }

    public void setEndPosition(long endPosition) {
        this.mEndPosition = endPosition;
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        this.mProgress = progress;
    }

    public DownloadStatus getStatus() {
        return mStatus;
    }

    public void setStatus(DownloadStatus status) {
        this.mStatus = status;
    }
}
