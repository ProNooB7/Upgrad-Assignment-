public Image getImageByTitle(String imageID){
final EntityManager em = new getEntityManager();
final CriterialBuilder cb = em.getCriteriaBuilder();
final CriteriaQuery<Some_Class> query =  cb.createQuery(Some_Class.class); // Some_Class is the class in which you can specify your qury structure
final Root<imageHoster> root = query.from(imageHoster.class);  // imageHoster will contains all the fields for a particular image or say main table
query.multiselect(root.get("imageSize"), root.get("imageCreationdate"), root.get("genre"), root.get("title")); // you can add as mnay info you wan to retrive

 final List<Predicate> predicates = new ArrayList<>(Util.getPredicates(cb, root, imageID));

 query.where(predicates.toArray(new Predicate[] {}));

 final TypedQuery<Some_Class> typedQuery = em.createQuery(query);
   return typedQuery.getResultList();
  }

here in Util.getPredicate you have to check for your query parameter
Suppose your imageID is 12345
so,
in Util.getPredicates()
cb.equals(root.get("imageID"), imageID); --> This will check if the imageID that  you are providing is valid or not.
