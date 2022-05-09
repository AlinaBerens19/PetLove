package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Pet type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Pets", authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Pet implements Model {
  public static final QueryField ID = field("Pet", "id");
  public static final QueryField NAME = field("Pet", "name");
  public static final QueryField OWNER_NAME = field("Pet", "ownerName");
  public static final QueryField EMAIL = field("Pet", "email");
  public static final QueryField AGE = field("Pet", "age");
  public static final QueryField KIND = field("Pet", "kind");
  public static final QueryField BREED = field("Pet", "breed");
  public static final QueryField PHONE = field("Pet", "phone");
  public static final QueryField PLACE = field("Pet", "place");
  public static final QueryField INFO = field("Pet", "info");
  public static final QueryField SEX = field("Pet", "sex");
  public static final QueryField IMAGE = field("Pet", "image");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="String") String ownerName;
  private final @ModelField(targetType="String") String email;
  private final @ModelField(targetType="Int") Integer age;
  private final @ModelField(targetType="String") String kind;
  private final @ModelField(targetType="String") String breed;
  private final @ModelField(targetType="String") String phone;
  private final @ModelField(targetType="String") String place;
  private final @ModelField(targetType="String") String info;
  private final @ModelField(targetType="String") String sex;
  private final @ModelField(targetType="String") String image;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getOwnerName() {
      return ownerName;
  }
  
  public String getEmail() {
      return email;
  }
  
  public Integer getAge() {
      return age;
  }
  
  public String getKind() {
      return kind;
  }
  
  public String getBreed() {
      return breed;
  }
  
  public String getPhone() {
      return phone;
  }
  
  public String getPlace() {
      return place;
  }
  
  public String getInfo() {
      return info;
  }
  
  public String getSex() {
      return sex;
  }
  
  public String getImage() {
      return image;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Pet(String id, String name, String ownerName, String email, Integer age, String kind, String breed, String phone, String place, String info, String sex, String image) {
    this.id = id;
    this.name = name;
    this.ownerName = ownerName;
    this.email = email;
    this.age = age;
    this.kind = kind;
    this.breed = breed;
    this.phone = phone;
    this.place = place;
    this.info = info;
    this.sex = sex;
    this.image = image;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Pet pet = (Pet) obj;
      return ObjectsCompat.equals(getId(), pet.getId()) &&
              ObjectsCompat.equals(getName(), pet.getName()) &&
              ObjectsCompat.equals(getOwnerName(), pet.getOwnerName()) &&
              ObjectsCompat.equals(getEmail(), pet.getEmail()) &&
              ObjectsCompat.equals(getAge(), pet.getAge()) &&
              ObjectsCompat.equals(getKind(), pet.getKind()) &&
              ObjectsCompat.equals(getBreed(), pet.getBreed()) &&
              ObjectsCompat.equals(getPhone(), pet.getPhone()) &&
              ObjectsCompat.equals(getPlace(), pet.getPlace()) &&
              ObjectsCompat.equals(getInfo(), pet.getInfo()) &&
              ObjectsCompat.equals(getSex(), pet.getSex()) &&
              ObjectsCompat.equals(getImage(), pet.getImage()) &&
              ObjectsCompat.equals(getCreatedAt(), pet.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), pet.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getOwnerName())
      .append(getEmail())
      .append(getAge())
      .append(getKind())
      .append(getBreed())
      .append(getPhone())
      .append(getPlace())
      .append(getInfo())
      .append(getSex())
      .append(getImage())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Pet {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("ownerName=" + String.valueOf(getOwnerName()) + ", ")
      .append("email=" + String.valueOf(getEmail()) + ", ")
      .append("age=" + String.valueOf(getAge()) + ", ")
      .append("kind=" + String.valueOf(getKind()) + ", ")
      .append("breed=" + String.valueOf(getBreed()) + ", ")
      .append("phone=" + String.valueOf(getPhone()) + ", ")
      .append("place=" + String.valueOf(getPlace()) + ", ")
      .append("info=" + String.valueOf(getInfo()) + ", ")
      .append("sex=" + String.valueOf(getSex()) + ", ")
      .append("image=" + String.valueOf(getImage()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Pet justId(String id) {
    return new Pet(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      ownerName,
      email,
      age,
      kind,
      breed,
      phone,
      place,
      info,
      sex,
      image);
  }
  public interface BuildStep {
    Pet build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep ownerName(String ownerName);
    BuildStep email(String email);
    BuildStep age(Integer age);
    BuildStep kind(String kind);
    BuildStep breed(String breed);
    BuildStep phone(String phone);
    BuildStep place(String place);
    BuildStep info(String info);
    BuildStep sex(String sex);
    BuildStep image(String image);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private String ownerName;
    private String email;
    private Integer age;
    private String kind;
    private String breed;
    private String phone;
    private String place;
    private String info;
    private String sex;
    private String image;
    @Override
     public Pet build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Pet(
          id,
          name,
          ownerName,
          email,
          age,
          kind,
          breed,
          phone,
          place,
          info,
          sex,
          image);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.email = email;
        return this;
    }
    
    @Override
     public BuildStep age(Integer age) {
        this.age = age;
        return this;
    }
    
    @Override
     public BuildStep kind(String kind) {
        this.kind = kind;
        return this;
    }
    
    @Override
     public BuildStep breed(String breed) {
        this.breed = breed;
        return this;
    }
    
    @Override
     public BuildStep phone(String phone) {
        this.phone = phone;
        return this;
    }
    
    @Override
     public BuildStep place(String place) {
        this.place = place;
        return this;
    }
    
    @Override
     public BuildStep info(String info) {
        this.info = info;
        return this;
    }
    
    @Override
     public BuildStep sex(String sex) {
        this.sex = sex;
        return this;
    }
    
    @Override
     public BuildStep image(String image) {
        this.image = image;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String ownerName, String email, Integer age, String kind, String breed, String phone, String place, String info, String sex, String image) {
      super.id(id);
      super.name(name)
        .ownerName(ownerName)
        .email(email)
        .age(age)
        .kind(kind)
        .breed(breed)
        .phone(phone)
        .place(place)
        .info(info)
        .sex(sex)
        .image(image);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder ownerName(String ownerName) {
      return (CopyOfBuilder) super.ownerName(ownerName);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
    
    @Override
     public CopyOfBuilder age(Integer age) {
      return (CopyOfBuilder) super.age(age);
    }
    
    @Override
     public CopyOfBuilder kind(String kind) {
      return (CopyOfBuilder) super.kind(kind);
    }
    
    @Override
     public CopyOfBuilder breed(String breed) {
      return (CopyOfBuilder) super.breed(breed);
    }
    
    @Override
     public CopyOfBuilder phone(String phone) {
      return (CopyOfBuilder) super.phone(phone);
    }
    
    @Override
     public CopyOfBuilder place(String place) {
      return (CopyOfBuilder) super.place(place);
    }
    
    @Override
     public CopyOfBuilder info(String info) {
      return (CopyOfBuilder) super.info(info);
    }
    
    @Override
     public CopyOfBuilder sex(String sex) {
      return (CopyOfBuilder) super.sex(sex);
    }
    
    @Override
     public CopyOfBuilder image(String image) {
      return (CopyOfBuilder) super.image(image);
    }
  }
  
}
