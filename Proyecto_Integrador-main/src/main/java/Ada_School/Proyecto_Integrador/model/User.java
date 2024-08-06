package Ada_School.Proyecto_Integrador.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection = "users")
    public class User {
        private Long id;

        @Id
        private String id;
        private String name;
        private String email;
        private String password;
        private String role;

        // Constructor con parámetros
        public User(Long id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        // Constructor vacío
        public User() {
        }

        // Getters y setters
        public Long getId() {
            // Getters y Setters
            public String getId () {
                return id;
            }

            public void setId (Long id){
                public void setId (String id){
                    this.id = id;
                }

                @ @ -39, 4 + 37, 20 @@public String getEmail () {
                    public void setEmail (String email){
                        this.email = email;
                    }

                    public String getPassword () {
                        return password;
                    }

                    public void setPassword (String password){
                        this.password = password;
                    }

                    public String getRole () {
                        return role;
                    }

                    public void setRole (String role){
                        this.role = role;
                    }
                }
            }
        }
    }

