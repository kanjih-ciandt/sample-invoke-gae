package com.sample.to;

public class ResultTest {
  private String id;
  private Double amount;
  private Double confidentialLevel;
  private String kind;
  private String etag;
  
  public ResultTest(String id, Double amount, Double confidentialLevel, String kind, String etag) {
    super();
    this.id = id;
    this.amount = amount;
    this.confidentialLevel = confidentialLevel;
    this.kind = kind;
    this.etag = etag;
  }
  
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public Double getAmount() {
    return amount;
  }
  public void setAmount(Double amount) {
    this.amount = amount;
  }
  public Double getConfidentialLevel() {
    return confidentialLevel;
  }
  public void setConfidentialLevel(Double confidentialLevel) {
    this.confidentialLevel = confidentialLevel;
  }
  public String getKind() {
    return kind;
  }
  public void setKind(String kind) {
    this.kind = kind;
  }
  public String getEtag() {
    return etag;
  }
  public void setEtag(String etag) {
    this.etag = etag;
  }

  @Override
  public String toString() {
    return "ResultTest [id=" + id + ", amount=" + amount + ", confidentialLevel="
        + confidentialLevel + ", kind=" + kind + ", etag=" + etag + "]";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((amount == null) ? 0 : amount.hashCode());
    result = prime * result + ((confidentialLevel == null) ? 0 : confidentialLevel.hashCode());
    result = prime * result + ((etag == null) ? 0 : etag.hashCode());
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((kind == null) ? 0 : kind.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ResultTest other = (ResultTest) obj;
    if (amount == null) {
      if (other.amount != null)
        return false;
    } else if (!amount.equals(other.amount))
      return false;
    if (confidentialLevel == null) {
      if (other.confidentialLevel != null)
        return false;
    } else if (!confidentialLevel.equals(other.confidentialLevel))
      return false;
    if (etag == null) {
      if (other.etag != null)
        return false;
    } else if (!etag.equals(other.etag))
      return false;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (kind == null) {
      if (other.kind != null)
        return false;
    } else if (!kind.equals(other.kind))
      return false;
    return true;
  }
  
  
  
  

}
