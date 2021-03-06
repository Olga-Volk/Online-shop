PGDMP         !                x            postgres    12.3    12.3 D    \           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ]           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ^           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            _           1262    13318    postgres    DATABASE     �   CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Russian_Russia.1251' LC_CTYPE = 'Russian_Russia.1251';
    DROP DATABASE postgres;
                postgres    false            `           0    0    DATABASE postgres    COMMENT     N   COMMENT ON DATABASE postgres IS 'default administrative connection database';
                   postgres    false    2911                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
                postgres    false            a           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                   postgres    false    4            �           1247    24671    status    TYPE     S   CREATE TYPE public.status AS ENUM (
    'collected',
    'paid',
    'received'
);
    DROP TYPE public.status;
       public          postgres    false    4            {           1247    24603    u_a    TYPE     <   CREATE TYPE public.u_a AS ENUM (
    'USER',
    'ADMIN'
);
    DROP TYPE public.u_a;
       public          postgres    false    4            �            1259    24645    balance    TABLE     �   CREATE TABLE public.balance (
    id integer NOT NULL,
    product_id integer,
    number integer,
    CONSTRAINT balance_number_check CHECK ((number >= 0))
);
    DROP TABLE public.balance;
       public         heap    postgres    false    4            �            1259    24643    balance_id_seq    SEQUENCE     �   CREATE SEQUENCE public.balance_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.balance_id_seq;
       public          postgres    false    4    210            b           0    0    balance_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.balance_id_seq OWNED BY public.balance.id;
          public          postgres    false    209            �            1259    24679    booking    TABLE     �   CREATE TABLE public.booking (
    id integer NOT NULL,
    client_id integer,
    booking_status public.status,
    transaction_id integer
);
    DROP TABLE public.booking;
       public         heap    postgres    false    655    4            �            1259    24677    booking_id_seq    SEQUENCE     �   CREATE SEQUENCE public.booking_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.booking_id_seq;
       public          postgres    false    4    214            c           0    0    booking_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.booking_id_seq OWNED BY public.booking.id;
          public          postgres    false    213            �            1259    24609    client    TABLE     �   CREATE TABLE public.client (
    id integer NOT NULL,
    email character varying(100),
    hash_code bigint,
    access_level character varying(6)
);
    DROP TABLE public.client;
       public         heap    postgres    false    4            �            1259    24607    client_id_seq    SEQUENCE     �   CREATE SEQUENCE public.client_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.client_id_seq;
       public          postgres    false    4    204            d           0    0    client_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.client_id_seq OWNED BY public.client.id;
          public          postgres    false    203            �            1259    24619    dealer    TABLE     �   CREATE TABLE public.dealer (
    id integer NOT NULL,
    name character varying(30) NOT NULL,
    adress character varying(200),
    phone character(11)
);
    DROP TABLE public.dealer;
       public         heap    postgres    false    4            �            1259    24617    diller_id_seq    SEQUENCE     �   CREATE SEQUENCE public.diller_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.diller_id_seq;
       public          postgres    false    4    206            e           0    0    diller_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.diller_id_seq OWNED BY public.dealer.id;
          public          postgres    false    205            �            1259    24705    goods    TABLE     �   CREATE TABLE public.goods (
    id integer NOT NULL,
    product_id integer,
    booking_id integer,
    number integer,
    discount integer
);
    DROP TABLE public.goods;
       public         heap    postgres    false    4            �            1259    24703    goods_id_seq    SEQUENCE     �   CREATE SEQUENCE public.goods_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.goods_id_seq;
       public          postgres    false    216    4            f           0    0    goods_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE public.goods_id_seq OWNED BY public.goods.id;
          public          postgres    false    215            �            1259    24631    product    TABLE       CREATE TABLE public.product (
    id integer NOT NULL,
    price integer NOT NULL,
    barcode character(13) NOT NULL,
    name_product character varying(200),
    description character varying(200),
    diller_id integer,
    CONSTRAINT product_price_check CHECK ((price >= 0))
);
    DROP TABLE public.product;
       public         heap    postgres    false    4            �            1259    24629    product_id_seq    SEQUENCE     �   CREATE SEQUENCE public.product_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.product_id_seq;
       public          postgres    false    4    208            g           0    0    product_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.product_id_seq OWNED BY public.product.id;
          public          postgres    false    207            �            1259    24659    transaction    TABLE     �   CREATE TABLE public.transaction (
    id integer NOT NULL,
    date_ date NOT NULL,
    client_id integer,
    full_price double precision
);
    DROP TABLE public.transaction;
       public         heap    postgres    false    4            �            1259    24657    transaction_id_seq    SEQUENCE     �   CREATE SEQUENCE public.transaction_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.transaction_id_seq;
       public          postgres    false    212    4            h           0    0    transaction_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.transaction_id_seq OWNED BY public.transaction.id;
          public          postgres    false    211            �
           2604    24648 
   balance id    DEFAULT     h   ALTER TABLE ONLY public.balance ALTER COLUMN id SET DEFAULT nextval('public.balance_id_seq'::regclass);
 9   ALTER TABLE public.balance ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    210    210            �
           2604    24682 
   booking id    DEFAULT     h   ALTER TABLE ONLY public.booking ALTER COLUMN id SET DEFAULT nextval('public.booking_id_seq'::regclass);
 9   ALTER TABLE public.booking ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    213    214            �
           2604    24612 	   client id    DEFAULT     f   ALTER TABLE ONLY public.client ALTER COLUMN id SET DEFAULT nextval('public.client_id_seq'::regclass);
 8   ALTER TABLE public.client ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    203    204            �
           2604    24622 	   dealer id    DEFAULT     f   ALTER TABLE ONLY public.dealer ALTER COLUMN id SET DEFAULT nextval('public.diller_id_seq'::regclass);
 8   ALTER TABLE public.dealer ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    206    205    206            �
           2604    24708    goods id    DEFAULT     d   ALTER TABLE ONLY public.goods ALTER COLUMN id SET DEFAULT nextval('public.goods_id_seq'::regclass);
 7   ALTER TABLE public.goods ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    216    215    216            �
           2604    24634 
   product id    DEFAULT     h   ALTER TABLE ONLY public.product ALTER COLUMN id SET DEFAULT nextval('public.product_id_seq'::regclass);
 9   ALTER TABLE public.product ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    208    207    208            �
           2604    24662    transaction id    DEFAULT     p   ALTER TABLE ONLY public.transaction ALTER COLUMN id SET DEFAULT nextval('public.transaction_id_seq'::regclass);
 =   ALTER TABLE public.transaction ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    212    212            S          0    24645    balance 
   TABLE DATA           9   COPY public.balance (id, product_id, number) FROM stdin;
    public          postgres    false    210   �I       W          0    24679    booking 
   TABLE DATA           P   COPY public.booking (id, client_id, booking_status, transaction_id) FROM stdin;
    public          postgres    false    214   �I       M          0    24609    client 
   TABLE DATA           D   COPY public.client (id, email, hash_code, access_level) FROM stdin;
    public          postgres    false    204   �I       O          0    24619    dealer 
   TABLE DATA           9   COPY public.dealer (id, name, adress, phone) FROM stdin;
    public          postgres    false    206   &J       Y          0    24705    goods 
   TABLE DATA           M   COPY public.goods (id, product_id, booking_id, number, discount) FROM stdin;
    public          postgres    false    216   CJ       Q          0    24631    product 
   TABLE DATA           [   COPY public.product (id, price, barcode, name_product, description, diller_id) FROM stdin;
    public          postgres    false    208   `J       U          0    24659    transaction 
   TABLE DATA           G   COPY public.transaction (id, date_, client_id, full_price) FROM stdin;
    public          postgres    false    212   }J       i           0    0    balance_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.balance_id_seq', 1, false);
          public          postgres    false    209            j           0    0    booking_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.booking_id_seq', 1, false);
          public          postgres    false    213            k           0    0    client_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.client_id_seq', 4, true);
          public          postgres    false    203            l           0    0    diller_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.diller_id_seq', 1, false);
          public          postgres    false    205            m           0    0    goods_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('public.goods_id_seq', 1, false);
          public          postgres    false    215            n           0    0    product_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.product_id_seq', 1, false);
          public          postgres    false    207            o           0    0    transaction_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.transaction_id_seq', 1, false);
          public          postgres    false    211            �
           2606    24651    balance balance_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.balance
    ADD CONSTRAINT balance_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.balance DROP CONSTRAINT balance_pkey;
       public            postgres    false    210            �
           2606    24684    booking booking_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_pkey;
       public            postgres    false    214            �
           2606    24616    client client_email_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_email_key UNIQUE (email);
 A   ALTER TABLE ONLY public.client DROP CONSTRAINT client_email_key;
       public            postgres    false    204            �
           2606    24614    client client_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.client
    ADD CONSTRAINT client_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.client DROP CONSTRAINT client_pkey;
       public            postgres    false    204            �
           2606    24626    dealer diller_adress_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.dealer
    ADD CONSTRAINT diller_adress_key UNIQUE (adress);
 B   ALTER TABLE ONLY public.dealer DROP CONSTRAINT diller_adress_key;
       public            postgres    false    206            �
           2606    24628    dealer diller_phone_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.dealer
    ADD CONSTRAINT diller_phone_key UNIQUE (phone);
 A   ALTER TABLE ONLY public.dealer DROP CONSTRAINT diller_phone_key;
       public            postgres    false    206            �
           2606    24624    dealer diller_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY public.dealer
    ADD CONSTRAINT diller_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY public.dealer DROP CONSTRAINT diller_pkey;
       public            postgres    false    206            �
           2606    24710    goods goods_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.goods
    ADD CONSTRAINT goods_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.goods DROP CONSTRAINT goods_pkey;
       public            postgres    false    216            �
           2606    24637    product product_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.product DROP CONSTRAINT product_pkey;
       public            postgres    false    208            �
           2606    24664    transaction transaction_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_pkey;
       public            postgres    false    212            �
           2606    24652    balance balance_product_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.balance
    ADD CONSTRAINT balance_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(id);
 I   ALTER TABLE ONLY public.balance DROP CONSTRAINT balance_product_id_fkey;
       public          postgres    false    208    2750    210            �
           2606    24685    booking booking_client_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(id);
 H   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_client_id_fkey;
       public          postgres    false    214    2742    204            �
           2606    24690 #   booking booking_transaction_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.booking
    ADD CONSTRAINT booking_transaction_id_fkey FOREIGN KEY (transaction_id) REFERENCES public.transaction(id);
 M   ALTER TABLE ONLY public.booking DROP CONSTRAINT booking_transaction_id_fkey;
       public          postgres    false    212    214    2754            �
           2606    24716    goods goods_booking_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.goods
    ADD CONSTRAINT goods_booking_id_fkey FOREIGN KEY (booking_id) REFERENCES public.booking(id);
 E   ALTER TABLE ONLY public.goods DROP CONSTRAINT goods_booking_id_fkey;
       public          postgres    false    2756    214    216            �
           2606    24711    goods goods_product_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY public.goods
    ADD CONSTRAINT goods_product_id_fkey FOREIGN KEY (product_id) REFERENCES public.product(id);
 E   ALTER TABLE ONLY public.goods DROP CONSTRAINT goods_product_id_fkey;
       public          postgres    false    216    208    2750            �
           2606    24638    product product_diller_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.product
    ADD CONSTRAINT product_diller_id_fkey FOREIGN KEY (diller_id) REFERENCES public.dealer(id);
 H   ALTER TABLE ONLY public.product DROP CONSTRAINT product_diller_id_fkey;
       public          postgres    false    208    206    2748            �
           2606    24665 &   transaction transaction_client_id_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.transaction
    ADD CONSTRAINT transaction_client_id_fkey FOREIGN KEY (client_id) REFERENCES public.client(id);
 P   ALTER TABLE ONLY public.transaction DROP CONSTRAINT transaction_client_id_fkey;
       public          postgres    false    204    2742    212            S      x������ � �      W      x������ � �      M   (   x�3�LL�/�KMqH�M���K���4426�4����� �
�      O      x������ � �      Y      x������ � �      Q      x������ � �      U      x������ � �     