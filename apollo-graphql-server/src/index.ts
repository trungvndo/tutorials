import { ApolloServer } from "@apollo/server";
import { startStandaloneServer } from "@apollo/server/standalone";
import { title } from "process";

const typeDefs = `#graphql

interface Book {
    title: String
    author: String
}

type Author {
    name: String
}

type TextBook implements Book {
    title: String
    author: String
    courses: [String]
}

type ColoringBook implements Book {
    title: String
    author: String
    colors: [String]
}

union SearchResult = TextBook | ColoringBook | Author

type Query {
    books: [Book]
    search: [SearchResult]
}
`;

const books = [
  {
    title: "The Awakening",
    author: "Kate Chopin",
    courses: [],
  },
  {
    title: "City of Glass",
    author: "Paul Auster",
    courses: [],
  },
  {
    title: "Apollo Server",
    author: "Jedi",
    courses: ["graphql"],
  },
  {
    title: "Drawing book",
    author: "Ben",
    colors: ["blue", "red", "green"],
  },
];

const authors = [
  { name: "Kate Chopin" },
  { name: "Paul Auster" },
  { name: "Luke Skywalker" },
];

const resolvers = {
  Book: {
    __resolveType(obj, contextValue, info) {
      if (obj.courses) {
        return "TextBook";
      }
      if (obj.colors) {
        return "ColoringBook";
      }
      return null;
    },
  },
  SearchResult: {
    __resolveType(obj, contextValue, info) {
      if (obj.name) {
        return "Author";
      }
      if (obj.title) {
        if (obj.courses) {
          return "TextBook";
        }
        if (obj.colors) {
          return "ColoringBook";
        }
      }
      return null;
    },
  },
  Query: {
    books: () => books,
    search: () => [...books, ...authors],
  },
};

const server = new ApolloServer({
  typeDefs,
  resolvers,
});

const { url } = await startStandaloneServer(server, {
  listen: {
    port: 4000,
  },
});

console.log(`Server ready at: ${url}`);
