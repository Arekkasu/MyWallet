PGDMP           
            |            mywallet    16.2    16.2 .    x           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            y           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            z           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            {           1262    16388    mywallet    DATABASE     t   CREATE DATABASE mywallet WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'en_US.UTF-8';
    DROP DATABASE mywallet;
                postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                pg_database_owner    false            |           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   pg_database_owner    false    4            �            1255    24616 '   update_total_amount_on_expense_change()    FUNCTION     "  CREATE FUNCTION public.update_total_amount_on_expense_change() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
        UPDATE users SET total_amount = total_amount + OLD.expense_amount WHERE id_users = OLD.users_id_users;
        RETURN OLD;
    ELSIF (TG_OP = 'INSERT') THEN
        UPDATE users SET total_amount = total_amount - NEW.expense_amount WHERE id_users = NEW.users_id_users;
        RETURN NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        IF NEW.expense_amount > OLD.expense_amount THEN
            -- Si el nuevo valor es mayor, disminuye total_amount
            UPDATE users SET total_amount = total_amount - (NEW.expense_amount - OLD.expense_amount) WHERE id_users = NEW.users_id_users;
        ELSIF NEW.expense_amount < OLD.expense_amount THEN
            -- Si el nuevo valor es menor, incrementa total_amount
            UPDATE users SET total_amount = total_amount + (OLD.expense_amount - NEW.expense_amount) WHERE id_users = NEW.users_id_users;
        END IF;
        RETURN NEW;
    END IF;
END;
$$;
 >   DROP FUNCTION public.update_total_amount_on_expense_change();
       public          postgres    false    4            �            1255    24613 '   update_total_amount_on_revenue_change()    FUNCTION     "  CREATE FUNCTION public.update_total_amount_on_revenue_change() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
    IF (TG_OP = 'DELETE') THEN
        UPDATE users SET total_amount = total_amount - OLD.revenue_amount WHERE id_users = OLD.users_id_users;
        RETURN OLD;
    ELSIF (TG_OP = 'INSERT') THEN
        UPDATE users SET total_amount = total_amount + NEW.revenue_amount WHERE id_users = NEW.users_id_users;
        RETURN NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        IF NEW.revenue_amount > OLD.revenue_amount THEN
            -- Si el nuevo valor es mayor, incrementa total_amount
            UPDATE users SET total_amount = total_amount + (NEW.revenue_amount - OLD.revenue_amount) WHERE id_users = NEW.users_id_users;
        ELSIF NEW.revenue_amount < OLD.revenue_amount THEN
            -- Si el nuevo valor es menor, disminuye total_amount
            UPDATE users SET total_amount = total_amount - (OLD.revenue_amount - NEW.revenue_amount) WHERE id_users = NEW.users_id_users;
        END IF;
        RETURN NEW;
    END IF;
END;
$$;
 >   DROP FUNCTION public.update_total_amount_on_revenue_change();
       public          postgres    false    4            �            1259    24740    expenses    TABLE     �   CREATE TABLE public.expenses (
    expense_amount integer NOT NULL,
    expense_date date,
    id_expenses bigint NOT NULL,
    users_id_users bigint,
    expense_description character varying(255),
    expense_header character varying(255)
);
    DROP TABLE public.expenses;
       public         heap    postgres    false    4            �            1259    24739    expenses_id_expenses_seq    SEQUENCE     �   CREATE SEQUENCE public.expenses_id_expenses_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.expenses_id_expenses_seq;
       public          postgres    false    4    216            }           0    0    expenses_id_expenses_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.expenses_id_expenses_seq OWNED BY public.expenses.id_expenses;
          public          postgres    false    215            �            1259    24749    revenue    TABLE     �   CREATE TABLE public.revenue (
    revenue_amount integer NOT NULL,
    revenue_date date,
    id_revenue bigint NOT NULL,
    users_id_users bigint,
    revenue_description character varying(255),
    revenue_header character varying(255)
);
    DROP TABLE public.revenue;
       public         heap    postgres    false    4            �            1259    24748    revenue_id_revenue_seq    SEQUENCE        CREATE SEQUENCE public.revenue_id_revenue_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.revenue_id_revenue_seq;
       public          postgres    false    4    218            ~           0    0    revenue_id_revenue_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.revenue_id_revenue_seq OWNED BY public.revenue.id_revenue;
          public          postgres    false    217            �            1259    24758    roles    TABLE     a   CREATE TABLE public.roles (
    id_role bigint NOT NULL,
    role_name character varying(255)
);
    DROP TABLE public.roles;
       public         heap    postgres    false    4            �            1259    24757    roles_id_role_seq    SEQUENCE     z   CREATE SEQUENCE public.roles_id_role_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.roles_id_role_seq;
       public          postgres    false    220    4                       0    0    roles_id_role_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.roles_id_role_seq OWNED BY public.roles.id_role;
          public          postgres    false    219            �            1259    24765    users    TABLE     �   CREATE TABLE public.users (
    total_amount integer NOT NULL,
    id_users bigint NOT NULL,
    email character varying(255) NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);
    DROP TABLE public.users;
       public         heap    postgres    false    4            �            1259    24764    users_id_users_seq    SEQUENCE     {   CREATE SEQUENCE public.users_id_users_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.users_id_users_seq;
       public          postgres    false    4    222            �           0    0    users_id_users_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.users_id_users_seq OWNED BY public.users.id_users;
          public          postgres    false    221            �            1259    24775    users_roles    TABLE     _   CREATE TABLE public.users_roles (
    id_role bigint NOT NULL,
    id_users bigint NOT NULL
);
    DROP TABLE public.users_roles;
       public         heap    postgres    false    4            �           2604    24743    expenses id_expenses    DEFAULT     |   ALTER TABLE ONLY public.expenses ALTER COLUMN id_expenses SET DEFAULT nextval('public.expenses_id_expenses_seq'::regclass);
 C   ALTER TABLE public.expenses ALTER COLUMN id_expenses DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    24752    revenue id_revenue    DEFAULT     x   ALTER TABLE ONLY public.revenue ALTER COLUMN id_revenue SET DEFAULT nextval('public.revenue_id_revenue_seq'::regclass);
 A   ALTER TABLE public.revenue ALTER COLUMN id_revenue DROP DEFAULT;
       public          postgres    false    218    217    218            �           2604    24761    roles id_role    DEFAULT     n   ALTER TABLE ONLY public.roles ALTER COLUMN id_role SET DEFAULT nextval('public.roles_id_role_seq'::regclass);
 <   ALTER TABLE public.roles ALTER COLUMN id_role DROP DEFAULT;
       public          postgres    false    220    219    220            �           2604    24768    users id_users    DEFAULT     p   ALTER TABLE ONLY public.users ALTER COLUMN id_users SET DEFAULT nextval('public.users_id_users_seq'::regclass);
 =   ALTER TABLE public.users ALTER COLUMN id_users DROP DEFAULT;
       public          postgres    false    221    222    222            n          0    24740    expenses 
   TABLE DATA           �   COPY public.expenses (expense_amount, expense_date, id_expenses, users_id_users, expense_description, expense_header) FROM stdin;
    public          postgres    false    216   1<       p          0    24749    revenue 
   TABLE DATA           �   COPY public.revenue (revenue_amount, revenue_date, id_revenue, users_id_users, revenue_description, revenue_header) FROM stdin;
    public          postgres    false    218   N<       r          0    24758    roles 
   TABLE DATA           3   COPY public.roles (id_role, role_name) FROM stdin;
    public          postgres    false    220   k<       t          0    24765    users 
   TABLE DATA           R   COPY public.users (total_amount, id_users, email, password, username) FROM stdin;
    public          postgres    false    222   �<       u          0    24775    users_roles 
   TABLE DATA           8   COPY public.users_roles (id_role, id_users) FROM stdin;
    public          postgres    false    223   =       �           0    0    expenses_id_expenses_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.expenses_id_expenses_seq', 1, false);
          public          postgres    false    215            �           0    0    revenue_id_revenue_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.revenue_id_revenue_seq', 1, false);
          public          postgres    false    217            �           0    0    roles_id_role_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.roles_id_role_seq', 1, false);
          public          postgres    false    219            �           0    0    users_id_users_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.users_id_users_seq', 1, true);
          public          postgres    false    221            �           2606    24747    expenses expenses_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.expenses
    ADD CONSTRAINT expenses_pkey PRIMARY KEY (id_expenses);
 @   ALTER TABLE ONLY public.expenses DROP CONSTRAINT expenses_pkey;
       public            postgres    false    216            �           2606    24756    revenue revenue_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.revenue
    ADD CONSTRAINT revenue_pkey PRIMARY KEY (id_revenue);
 >   ALTER TABLE ONLY public.revenue DROP CONSTRAINT revenue_pkey;
       public            postgres    false    218            �           2606    24763    roles roles_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.roles
    ADD CONSTRAINT roles_pkey PRIMARY KEY (id_role);
 :   ALTER TABLE ONLY public.roles DROP CONSTRAINT roles_pkey;
       public            postgres    false    220            �           2606    24799 !   users uktbpk8dt8cn41jgc3c5cjmulf1 
   CONSTRAINT     `   ALTER TABLE ONLY public.users
    ADD CONSTRAINT uktbpk8dt8cn41jgc3c5cjmulf1 UNIQUE (username);
 K   ALTER TABLE ONLY public.users DROP CONSTRAINT uktbpk8dt8cn41jgc3c5cjmulf1;
       public            postgres    false    222            �           2606    24772    users users_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id_users);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public            postgres    false    222            �           2606    24774    users users_username_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_username_key UNIQUE (username);
 B   ALTER TABLE ONLY public.users DROP CONSTRAINT users_username_key;
       public            postgres    false    222            �           2620    24801    expenses expense_change    TRIGGER     �   CREATE TRIGGER expense_change AFTER INSERT OR DELETE OR UPDATE ON public.expenses FOR EACH ROW EXECUTE FUNCTION public.update_total_amount_on_expense_change();
 0   DROP TRIGGER expense_change ON public.expenses;
       public          postgres    false    216    236            �           2620    24800    revenue revenue_change_trigger    TRIGGER     �   CREATE TRIGGER revenue_change_trigger AFTER INSERT OR DELETE OR UPDATE ON public.revenue FOR EACH ROW EXECUTE FUNCTION public.update_total_amount_on_revenue_change();
 7   DROP TRIGGER revenue_change_trigger ON public.revenue;
       public          postgres    false    235    218            �           2606    24788 '   users_roles fk3avenccqsoqwrfur1hb8mpbrw    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk3avenccqsoqwrfur1hb8mpbrw FOREIGN KEY (id_role) REFERENCES public.roles(id_role);
 Q   ALTER TABLE ONLY public.users_roles DROP CONSTRAINT fk3avenccqsoqwrfur1hb8mpbrw;
       public          postgres    false    220    223    3281            �           2606    24783 #   revenue fk982mwnl5yf56tx7prfrh7dp2d    FK CONSTRAINT     �   ALTER TABLE ONLY public.revenue
    ADD CONSTRAINT fk982mwnl5yf56tx7prfrh7dp2d FOREIGN KEY (users_id_users) REFERENCES public.users(id_users);
 M   ALTER TABLE ONLY public.revenue DROP CONSTRAINT fk982mwnl5yf56tx7prfrh7dp2d;
       public          postgres    false    222    3285    218            �           2606    24793 '   users_roles fkq0tw71wffd6bfr4fofq7iiqqi    FK CONSTRAINT     �   ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkq0tw71wffd6bfr4fofq7iiqqi FOREIGN KEY (id_users) REFERENCES public.users(id_users);
 Q   ALTER TABLE ONLY public.users_roles DROP CONSTRAINT fkq0tw71wffd6bfr4fofq7iiqqi;
       public          postgres    false    223    3285    222            �           2606    24778 $   expenses fks0dpvta4s86ax6s1go5m85yee    FK CONSTRAINT     �   ALTER TABLE ONLY public.expenses
    ADD CONSTRAINT fks0dpvta4s86ax6s1go5m85yee FOREIGN KEY (users_id_users) REFERENCES public.users(id_users);
 N   ALTER TABLE ONLY public.expenses DROP CONSTRAINT fks0dpvta4s86ax6s1go5m85yee;
       public          postgres    false    222    3285    216            n      x������ � �      p      x������ � �      r   !   x�3���q�v�2��]|=��b���� t��      t   g   x�3�4�L,J�6607tH�M���K���T1JT14P)4��r�r��7�+�K*M�*�/5ά(���*5ww�5�����p140ҫ
����X\����� �`.      u      x�3�4�2�=... ��     