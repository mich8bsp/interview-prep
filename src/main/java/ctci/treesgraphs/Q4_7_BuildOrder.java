package ctci.treesgraphs;

import java.util.*;

public class Q4_7_BuildOrder {

    private static class Project{
        private String name;
        private List<Project> dependencies;
        private boolean visitedMidIteration;
        private boolean isAdded;

        public Project(String name) {
            this.name = name;
            this.dependencies = new LinkedList<>();
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void addDependency(Project project){
            this.dependencies.add(project);
        }

        @Override
        public String toString() {
            return "Project{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static List<Project> getBuildOrder(List<Project> projects, List<AbstractMap.SimpleEntry<Project, Project>> dependencies) throws Exception {
        Map<String, Project> projectsMap = buildProjectsMap(projects, dependencies);
        List<Project> buildOrder = new LinkedList<>();
        for(Project node : projectsMap.values()){
            handleNode(node, buildOrder);
        }
        return buildOrder;
    }

    private static void handleNode(Project node, List<Project> buildOrder) throws Exception {
        if(node.isAdded){
            return;
        }
        if(node.visitedMidIteration){
            throw new Exception("Cyclic dependency");
        }
        node.visitedMidIteration = true; //we do not add it yet because we need to add its dependencies, but we mark to check for cyclic dependencies
        for(Project dep : node.dependencies){
            handleNode(dep, buildOrder);
        }
        buildOrder.add(node);
        node.isAdded = true;
    }

    private static Map<String, Project> buildProjectsMap(List<Project> projects, List<AbstractMap.SimpleEntry<Project, Project>> dependencies){
        Map<String, Project> projectsMap = new HashMap<>();
        projects.forEach(proj -> projectsMap.put(proj.getName(), proj));
        for(AbstractMap.SimpleEntry<Project, Project> dep : dependencies){
            Project dependency = projectsMap.get(dep.getKey().getName());
            Project parent = projectsMap.get(dep.getValue().getName());
            parent.addDependency(dependency);
        }
        return projectsMap;
    }

    public static void main(String[] args) throws Exception {
        List<AbstractMap.SimpleEntry<Project, Project>> dependencies = new LinkedList<>();
        Project a = new Project("a");
        Project b = new Project("b");
        Project c = new Project("c");
        Project d = new Project("d");
        Project e = new Project("e");
        Project f = new Project("f");
        List<Project> projects = Arrays.asList(a,b,c,d,e,f);
        dependencies.add(new AbstractMap.SimpleEntry<>(a, d));
        dependencies.add(new AbstractMap.SimpleEntry<>(f, b));
        dependencies.add(new AbstractMap.SimpleEntry<>(b, d));
        dependencies.add(new AbstractMap.SimpleEntry<>(f, a));
        dependencies.add(new AbstractMap.SimpleEntry<>(d, c));
        System.out.println(getBuildOrder(projects, dependencies));
    }
}
